package it.nepsthermoney.service.impl;

import it.nepsthermoney.entity.Release;
import it.nepsthermoney.execptions.ObjectNotFoundException;
import it.nepsthermoney.repository.ReleaseRepository;
import it.nepsthermoney.service.ReleaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReleaseServiceImpl implements ReleaseService {
    ReleaseRepository releaseRepository;
    @Override
    public Release findById(Long id) {
        Optional<Release> release = releaseRepository.findById(id);
        return  release.orElseThrow(() -> new ObjectNotFoundException("No release  was found with this identifier " + id));
    }

    @Override
    public List<Release> findAll() {
        return releaseRepository.findAll();
    }

    @Override
    public Release save(Release release) {
        release.setId(null);
        return releaseRepository.save(release);
    }

    @Override
    public Release update(Long id, Release release) {
        Release releaseExist = findById(id);
        //releaseExist.setName(release.getName());
        return releaseRepository.save(releaseExist);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        releaseRepository.deleteById(id);
    }
}
