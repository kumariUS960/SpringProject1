package com.tnsif.placement.service;

import com.tnsif.placement.entity.Certificate;
import com.tnsif.placement.repository.CertificateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificateService {

    private final CertificateRepository certificateRepository;

    public CertificateService(CertificateRepository certificateRepository) {
        this.certificateRepository = certificateRepository;
    }

    public List<Certificate> getAllCertificates() {
        return certificateRepository.findAll();
    }

    public Optional<Certificate> getCertificateById(Long id) {
        return certificateRepository.findById(id);
    }

    public Certificate addCertificate(Certificate certificate) {
        return certificateRepository.save(certificate);
    }

    public Certificate updateCertificate(Long id, Certificate updatedCertificate) {
        return certificateRepository.findById(id).map(c -> {
            c.setStudentName(updatedCertificate.getStudentName());
            c.setRollNo(updatedCertificate.getRollNo());
            c.setCourse(updatedCertificate.getCourse());
            c.setBranch(updatedCertificate.getBranch());
            c.setCompany(updatedCertificate.getCompany());
            c.setIssueDate(updatedCertificate.getIssueDate());
            c.setGrade(updatedCertificate.getGrade());
            return certificateRepository.save(c);
        }).orElseThrow(() -> new RuntimeException("Certificate not found"));
    }

    public void deleteCertificate(Long id) {
        certificateRepository.deleteById(id);
    }
}
