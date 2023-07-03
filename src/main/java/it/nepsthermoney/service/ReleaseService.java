package it.nepsthermoney.service;

import it.nepsthermoney.entity.Release;
import it.nepsthermoney.repository.filter.ReleaseFilter;

import java.util.List;

public interface ReleaseService {

    Release findById(Long id);

    List<Release> findAll();

    Release save(Release release);

    Release update(Long id, Release release);

    void delete(Long id);

    List<Release> filterRelease(ReleaseFilter releaseFilter);
}
