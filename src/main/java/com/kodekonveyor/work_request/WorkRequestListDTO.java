package com.kodekonveyor.work_request;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class WorkRequestListDTO {

	private List<WorkRequestDTO> requests = new ArrayList<>();

}
