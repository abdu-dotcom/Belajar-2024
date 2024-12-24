package net.javaguides.department_service.repository;

import net.javaguides.department_service.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepaartmentRepository extends JpaRepository<Department, Long> {}
