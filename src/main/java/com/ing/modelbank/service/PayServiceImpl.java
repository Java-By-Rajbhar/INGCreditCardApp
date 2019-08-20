package com.ing.modelbank.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.ing.modelbank.dto.CreditCardRequestDto;
import com.ing.modelbank.dto.PayResponseDto;
import com.ing.modelbank.entity.CreditCard;
import com.ing.modelbank.entity.Otp;
import com.ing.modelbank.exception.CreditCardDoesNotExistsException;
import com.ing.modelbank.exception.WrongCreditCardDetailException;
import com.ing.modelbank.repository.CreditCardRepository;
import com.ing.modelbank.repository.OtpRepository;

/**
 * 
 * @author Sushil
 *
 */
@Service
public class PayServiceImpl implements PayService {
	@Autowired
	CreditCardRepository creditCardRepository;

	@Autowired
	MailService mailService;

	@Autowired
	OtpRepository otpRepository;

	private static final Logger logger = LoggerFactory.getLogger(PayServiceImpl.class);

	@Override
	public PayResponseDto pay(CreditCardRequestDto creditCardRequestDto) {
		logger.info("inside pay method of PayServiceImpl class");
		/* get credit card object customer id */

		CreditCard creditCardDetail = creditCardRepository.findByCustomerCustomerId(creditCardRequestDto.getCustomerId());
		logger.info("email  data={}", creditCardDetail.getCustomer().getEmail());

		if (creditCardDetail != null) {
			
			if (creditCardDetail.getCardCardNumber().equals(creditCardRequestDto.getCardCardNumber())
					&& creditCardDetail.getCvv() == creditCardRequestDto.getCvv()
					&& creditCardDetail.getExpiryDate().equals(creditCardRequestDto.getExpiryDate()) && creditCardDetail
							.getCreditCardHolderName().equals(creditCardRequestDto.getCreditCardHolderName())) {
				/* call otp generate service to generate otp */
				Random rand = new Random();
				long otp = 1000 + rand.nextInt(9999);

				mailService.sendEmails(creditCardDetail.getCustomer().getEmail(), creditCardDetail.getCreditCardId(),
						otp);
				//create otp object
				Otp otp1 =  new Otp();
				otp1.setOtp(otp);
				otp1.setReferenceId(creditCardDetail.getCreditCardId());
				//save otp detail in table
				otpRepository.save(otp1);
				//generate response
				PayResponseDto payResponseDto = new PayResponseDto();
				payResponseDto.setStatusCode(HttpStatus.OK.value());
				payResponseDto.setMessage("Please verify your otp");
				
				return payResponseDto;
			} else {
				throw new WrongCreditCardDetailException("Please provide correct credit card detials !!!! ");
			}

		} else {
			throw new CreditCardDoesNotExistsException("Customer ID " + creditCardRequestDto.getCustomerId() + " does not exist");
		}
	}

}
