package com.ing.modelbank.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ing.modelbank.dto.DeleteResponseDto;
import com.ing.modelbank.entity.Account;
import com.ing.modelbank.entity.Customer;
import com.ing.modelbank.entity.Payee;
import com.ing.modelbank.repository.PayeeRepository;


@RunWith(SpringJUnit4ClassRunner.class)
public class DeletePayeeServiceImplTest {

	
	@Mock
	PayeeRepository payeeRepository;
	
	@InjectMocks
	DeletePayeeServiceImpl deletePayeeServiceImpl;
	
	
	@Test
	public void testDeletePayee() {
 
		
		Payee payee = new Payee();
		Account account=new Account();
		account.setAccountId(1L);
		account.setAccountNumber(1234);
		account.setAccountType("SBA");
		
		Customer customer=new Customer();
		customer.setAddress("BTM");
		customer.setAge(30L);
		customer.setCustomerId(1L);
		customer.setEmail("a@a.com");
		customer.setFirstName("shashank");
		customer.setLastName("Kumar");
		customer.setLoginId("1");
		customer.setMobileNo(8970297757L);
		customer.setPan("CKL5");
		customer.setPassword("ok");
		account.setBalance(50000.0);
	
		payee.setAccount(account);
		payee.setAccountNumber(1234);
		payee.setEmailId("b@b.com");
		payee.setIFSC("IFSC1");
		payee.setPayeeId(1L);
		payee.setPayeeName("SUSIL");
		payee.setStatus("ACTIVATE");
		
		Optional<Payee> optionalPayee=Optional.of(payee);
		
		when(payeeRepository.findById(Mockito.anyLong())).thenReturn(optionalPayee);
		
		DeleteResponseDto deleteResponseDtoactual=	deletePayeeServiceImpl.deletePayee(1L);
		assertEquals("Payee Deleted", deleteResponseDtoactual.getMessage());
	
	}

}
