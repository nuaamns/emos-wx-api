package com.mns.emos.wx.db.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TbHolidaysDao {
    public Integer searchTodayIsHolidays();
}