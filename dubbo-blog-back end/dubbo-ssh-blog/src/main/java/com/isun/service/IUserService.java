package com.isun.service;

import com.isun.entity.AcctUser;

import java.util.List;

public interface IUserService {

        AcctUser load(String id);

        AcctUser get(String id);

        void delete(String id);

        void flush();

}
