package com.zhongyuguoji.www.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zhongyuguoji.www.entity.Members;

@Repository
@Transactional
public interface MembersMapper extends JpaRepository<Members, Integer> {

	@Query(value = "update Members as mb set mb.totalCount?1,mb.totalNew?2", nativeQuery = true)
	void updateTimer(Long totalCount, Long totalNew);

}
