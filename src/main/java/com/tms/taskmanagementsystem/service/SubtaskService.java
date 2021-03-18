package com.tms.taskmanagementsystem.service;

import com.tms.taskmanagementsystem.domain.Subtask;
import com.tms.taskmanagementsystem.dto.SubtaskDto;
import com.tms.taskmanagementsystem.mapper.SubtaskConverter;
import com.tms.taskmanagementsystem.repository.subtaskRepository.SubtaskRepository;
import com.tms.taskmanagementsystem.service.validation.subtaskValidation.SubtaskValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class SubtaskService {

    private SubtaskRepository subtaskRepository;
    private SubtaskConverter subtaskConverter;
    private SubtaskValidationService validationService;

    @Autowired
    public SubtaskService(SubtaskRepository subtaskRepository, SubtaskConverter subtaskConverter, SubtaskValidationService validationService) {
        this.subtaskRepository = subtaskRepository;
        this.subtaskConverter = subtaskConverter;
        this.validationService = validationService;
    }

    public Long createSubtask(SubtaskDto subtaskDto) {
        validationService.validate(subtaskDto);
        Subtask subtask = subtaskConverter.convert(subtaskDto);
        subtaskRepository.save(subtask);
        return subtask.getId();
    }

    public void deleteSubtaskById(Long id) {
        subtaskRepository.findById(id)
                .ifPresent(subtaskRepository::delete);
    }

    public List<SubtaskDto> showAllSubtask() {
        return subtaskRepository.findAll().stream()
                .map(subtask -> subtaskConverter.convert(subtask))
                .collect(Collectors.toList());
    }

    public void updateSubtask(SubtaskDto subtaskDto) {
        validationService.validate(subtaskDto);
        Subtask subtask = subtaskConverter.convert(subtaskDto);
        subtaskRepository.save(subtask);
    }

    public SubtaskDto findSubtaskById(Long id) {
        return subtaskRepository.findById(id)
                .map(subtaskConverter::convert)
                .orElseThrow(() -> new NoSuchElementException("Subtask not found by id : " + id));
    }
}
