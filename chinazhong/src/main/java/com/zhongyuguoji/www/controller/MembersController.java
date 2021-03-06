package com.zhongyuguoji.www.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhongyuguoji.www.common.constans.Constants;
import com.zhongyuguoji.www.entity.Members;
import com.zhongyuguoji.www.service.MembersService;
import com.zhongyuguoji.www.util.ResponseUtils;
/**
 * members form
 * @author moese
 *
 */
@RestController
@RequestMapping("/members")
public class MembersController {
	@Resource
	private MembersService ms;
	/**
	 * getMembersAll
	 * @param response
	 */
	@GetMapping("/getAll")
	public void getAllMembers(HttpServletResponse response) {
		List<Members> members = ms.getAll();
		ResponseUtils.responseAsJson(Constants.Success.COMMON_CODE,
				Constants.Success.DESC.get(Constants.Success.COMMON_CODE), members, response);
	}
	/**
	 * getObjectById
	 * @param id
	 * @param response
	 */
	@GetMapping("/getMembers")
	public void getMembersById(Integer id, HttpServletResponse response) {
		if (id != null) {
			Members membersBySid = ms.getMembersBySid(id);
			ResponseUtils.responseAsJson(Constants.Success.COMMON_CODE,
					Constants.Success.DESC.get(Constants.Success.COMMON_CODE), membersBySid, response);
		}

	}
	/**
	 * save Object
	 * @param entity
	 * @param response
	 */
	@PostMapping("/saveEntity")
	public void updateMember(Members entity, HttpServletResponse response) {
		if (entity != null) {
			ms.saveMembers(entity);
			ResponseUtils.responseAsJson(Constants.Success.COMMON_CODE,
					Constants.Success.DESC.get(Constants.Success.COMMON_CODE), response);
		}

	}
	
}
