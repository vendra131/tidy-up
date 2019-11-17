package com.kodekonveyor.work_request;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.kodekonveyor.authentication.UserEntity;
import com.kodekonveyor.authentication.UserEntityRepository;
import com.kodekonveyor.webapp.ValidationException;

@Controller
public class CustomerGetWorkRequestsController {
	@Autowired
	public WorkRequestRepository workRequestRepository;
	@Autowired
	public UserEntityRepository userEntityRepository;

	public WorkRequestListDTO call(final String ownerId) {
		checkOwnerId(ownerId);

		final Optional<UserEntity> user = userEntityRepository.findById(Long.parseLong(ownerId));
		final List<WorkRequestEntity> requests = workRequestRepository.findByCustomer(user.get());
		final WorkRequestListDTO workRequestListDTO = new WorkRequestListDTO();
		for (final WorkRequestEntity workRequestEntity : requests) {
			final WorkRequestDTO workRequestDTO = createWorkRequset();
			workRequestDTO.setWorkType(workRequestEntity.getWorkType());
			workRequestDTO.setWorkRequestId(workRequestEntity.getId());
			workRequestListDTO.getRequests().add(workRequestDTO);

		}

		return workRequestListDTO;
	}

	private WorkRequestDTO createWorkRequset() {
		return new WorkRequestDTO();
	}

	public void checkOwnerId(final String ownerId) {
		if (null == ownerId)
			throw new ValidationException(WorkRequestConstants.NULL_OWNERID);

	}

}
