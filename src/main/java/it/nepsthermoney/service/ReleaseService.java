package it.nepsthermoney.service;

import it.nepsthermoney.entity.Release;
import it.nepsthermoney.repository.filter.ReleaseFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReleaseService {

    Release findById(Long id);

    List<Release> findAll();

    Release save(Release release);

    Release update(Long id, Release release);

    void delete(Long id);

    Page<Release> filterRelease(ReleaseFilter releaseFilter, Pageable pageable);
}
