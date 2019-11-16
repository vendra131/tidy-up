package com.kodekonveyor.work_request.open;

import org.springframework.stereotype.Repository;

@Repository
public interface WorkRequestRepository {

	WorkRequestEntity findByWorkRequestId(long workrequestId);

}
