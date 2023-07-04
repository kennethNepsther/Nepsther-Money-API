package it.nepsthermoney.repository;

import it.nepsthermoney.entity.Release;
import it.nepsthermoney.repository.filter.ReleaseFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReleaseRepositoryQuery  {
    Page<Release> filterRelease(ReleaseFilter releaseFilter, Pageable pageable);
}
