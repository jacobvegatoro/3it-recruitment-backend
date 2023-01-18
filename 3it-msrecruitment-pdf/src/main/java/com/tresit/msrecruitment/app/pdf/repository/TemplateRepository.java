package com.tresit.msrecruitment.app.pdf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tresit.msrecruitment.app.pdf.model.Template;

public interface TemplateRepository extends JpaRepository<Template, Long> {

}
