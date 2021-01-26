package com.mns.emos.wx.service;

import com.mns.emos.wx.db.pojo.TbUser;

import java.util.Set;

public interface UserService {

    public int registerUser(String registerCode, String code, String nickname, String photo);

    public Set<String> searchUserPermissions(int userId);

    public Integer login(String code);

    public TbUser searchById(int userId);
}
