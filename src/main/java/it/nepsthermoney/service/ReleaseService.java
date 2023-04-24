package it.nepsthermoney.service;

import it.nepsthermoney.entity.Release;

import java.util.List;

public interface ReleaseService {

    Release findById(Long id);

    List<Release> findAll();

    Release save(Release release);

    Release update(Long id, Release release);

    void delete(Long id);
}
