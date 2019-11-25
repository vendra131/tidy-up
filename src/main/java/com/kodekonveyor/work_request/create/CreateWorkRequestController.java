package com.kodekonveyor.work_request.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.authentication.UserEntity;
import com.kodekonveyor.work_request.AddressEntity;
import com.kodekonveyor.work_request.WorkRequestEntity;
import com.kodekonveyor.work_request.WorkRequestRepository;

@Controller
public class CreateWorkRequestController {

	@Autowired
	private AuthenticatedUserService authenticatedUserService;

	@Autowired
	private WorkRequestRepository workRequestRepository;

	@PostMapping("/work-request")
	public void call(@RequestBody final CreateWorkRequestDTO createWorkRequestDTO) {
		final WorkRequestEntity workRequestEntity = new WorkRequestEntity();
		workRequestEntity.setWorkType(createWorkRequestDTO.getWorkType());
		final UserEntity userEntity = authenticatedUserService.call();
		final AddressEntity addressEntity = new AddressEntity();
		addressEntity.setAddress(createWorkRequestDTO.getAddress().getAddress());
		addressEntity.setCity(createWorkRequestDTO.getAddress().getCity());
		addressEntity.setCountry(createWorkRequestDTO.getAddress().getCountry());
		workRequestEntity.setCustomer(userEntity);
		workRequestEntity.setId(createWorkRequestDTO.getCustomerId());
		workRequestEntity.setDescription(createWorkRequestDTO.getDescription());
		workRequestEntity.setAddress(addressEntity);

		workRequestRepository.save(workRequestEntity);
	}

}
