package com.mont.rasmooplus.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mont.rasmooplus.dto.PaymentProcessDto;
import com.mont.rasmooplus.dto.wsraspay.CustomerDto;
import com.mont.rasmooplus.dto.wsraspay.OrderDto;
import com.mont.rasmooplus.dto.wsraspay.PaymentDto;
import com.mont.rasmooplus.exception.BusinessException;
import com.mont.rasmooplus.exception.NotFoundException;
import com.mont.rasmooplus.integration.MailIntegration;
import com.mont.rasmooplus.integration.WsRaspayIntegration;
import com.mont.rasmooplus.mapper.UserPaymentInfoMapper;
import com.mont.rasmooplus.mapper.wsraspay.CreditCardMapper;
import com.mont.rasmooplus.mapper.wsraspay.CustomerMapper;
import com.mont.rasmooplus.mapper.wsraspay.OrderMapper;
import com.mont.rasmooplus.mapper.wsraspay.PaymentMapper;
import com.mont.rasmooplus.model.User;
import com.mont.rasmooplus.model.UserPaymentInfo;
import com.mont.rasmooplus.repository.UserPaymentInfoRepository;
import com.mont.rasmooplus.repository.UserRepository;
import com.mont.rasmooplus.service.PaymentInfoService;


@Service
public class PaymentInfoServiceImpl implements PaymentInfoService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserPaymentInfoRepository userPaymentInfoRepository;

    @Autowired
    private WsRaspayIntegration wsRaspayIntegration;

    @Autowired
    private MailIntegration mailIntegration;


    @Override
    public Boolean process(PaymentProcessDto dto) {
        //verify user by id and verify if exist subscription
        User userEntity = userRepository.findById(dto.getUserPaymentInfoDto().getUserId()).orElseThrow(() -> new NotFoundException("User not found"));
        
        if(Objects.nonNull(userEntity.getSubscriptionType())) {
            throw new BusinessException("Payment can not be processed. User already has subscription");
        }
       
        //create or update user raspay
        CustomerDto customerDto = wsRaspayIntegration.createCustomer(CustomerMapper.build(userEntity));
        //create the payment order
        OrderDto orderDto = wsRaspayIntegration.createOrder(OrderMapper.build(customerDto.getId(), dto));
        //process the payment 
        PaymentDto paymentDto = PaymentMapper.build(customerDto.getId(), orderDto.getCustomerId(), CreditCardMapper.build(dto.getUserPaymentInfoDto(), userEntity.getCpf()));
        Boolean successPayment = wsRaspayIntegration.processPayment(paymentDto);
         
        if(successPayment) {
            //save payment informations
         UserPaymentInfo userPaymentInfo = UserPaymentInfoMapper.fromDtoToEntity(dto.getUserPaymentInfoDto(), userEntity);
         userPaymentInfoRepository.save(userPaymentInfo);

            //send account created email
        mailIntegration.send(userEntity.getEmail(), "Aqui está suas credenciais de acesso:\n Login: "
        + userEntity.getEmail() + "\n Senha: alunorasmoo", "Conta criada com sucesso!");
         return true;
        }
     
        //return success or not of the payment

        return false;
    }
    
}
