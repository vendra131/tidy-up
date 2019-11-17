package com.kodekonveyor.work_request.open;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRequestRepository extends CrudRepository<WorkRequestEntity, Long> {

	WorkRequestEntity findByWorkRequestId(long workrequestId);

}
