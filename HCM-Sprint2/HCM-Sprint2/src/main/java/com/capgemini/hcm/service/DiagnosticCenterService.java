package com.capgemini.hcm.service;

import com.capgemini.hcm.dao.DiagnosticCenterDao;
import com.capgemini.hcm.entity.DiagnosticCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DiagnosticCenterService {

    @Autowired
    private DiagnosticCenterDao diagnosticCenterDao;

    @Transactional
    public boolean addcenter(DiagnosticCenter diagnosticcenter) {
        return diagnosticCenterDao.save(diagnosticcenter) != null;
    }

    @Transactional
    public List<DiagnosticCenter> listallcenter() {
        return diagnosticCenterDao.findAll();
    }

    @Transactional

    public void deletecenter(Integer centerId) {
        diagnosticCenterDao.deleteById(centerId);
    }

    @Transactional
    public DiagnosticCenter updatecenter(DiagnosticCenter diagnosticcenter, Integer centerId) {
        return diagnosticCenterDao.save(diagnosticcenter);
    }


}
