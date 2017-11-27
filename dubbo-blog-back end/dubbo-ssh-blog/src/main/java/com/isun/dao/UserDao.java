package com.isun.dao;

import java.util.List;

import com.isun.entity.AcctUser;

/**
 * 用户Dao接口
 */

public interface UserDao {

	AcctUser load(String id);

}
