package it.nepsthermoney.service.impl;

import it.nepsthermoney.entity.Category;
import it.nepsthermoney.entity.Person;
import it.nepsthermoney.entity.Release;
import it.nepsthermoney.execptions.InactivePersonException;
import it.nepsthermoney.execptions.ObjectNotFoundException;
import it.nepsthermoney.repository.ReleaseRepository;
import it.nepsthermoney.service.CategoryService;
import it.nepsthermoney.service.PersonService;
import it.nepsthermoney.service.ReleaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReleaseServiceImpl implements ReleaseService {
    ReleaseRepository releaseRepository;
    final CategoryService categoryService;
    final PersonService personService;
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

        Category categoryExists = categoryService.findById(release.getCategory().getId());
        Person personExists = personService.findById(release.getPerson().getId());
        if (personExists.isInactive()) {
            throw new InactivePersonException("Person is inactive");
        }
        release.setId(null);
        release.setPerson(personExists);
        release.setCategory(categoryExists);
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
