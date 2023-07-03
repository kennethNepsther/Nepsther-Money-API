package it.nepsthermoney.repository;

import it.nepsthermoney.entity.Release;
import it.nepsthermoney.repository.filter.ReleaseFilter;

import java.util.List;

public interface ReleaseRepositoryQuery  {
    List<Release> filterRelease(ReleaseFilter releaseFilter);
}
