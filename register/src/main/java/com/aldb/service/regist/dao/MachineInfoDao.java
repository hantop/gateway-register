package com.aldb.service.regist.dao;

import com.aldb.service.regist.dao.bean.MachineInfo;

public interface MachineInfoDao {
    Long getMachineInfoIdNextVal();

    MachineInfo getMachineInfoById(Long oid);

    int insertMachineInfo(MachineInfo record);

    int insertSelectiveMachineInfo(MachineInfo record);

    int updateMachineInfoById(MachineInfo record);

    int updateSelectiveMachineInfoById(MachineInfo record);

    int deleteMachineInfoById(Long oid);
}