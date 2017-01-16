package nl.animundo.apps.alpacashowadmin.backend.repositories;

import nl.animundo.apps.alpacashowadmin.backend.domain.Animal;
import nl.animundo.apps.alpacashowadmin.backend.domain.Participant;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEventRegistration;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeClass;
import nl.animundo.apps.alpacashowadmin.backend.services.AgeClassService;
import nl.animundo.apps.alpacashowadmin.backend.services.ShowClassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ShowEventRegistrationRepository {
    private static Logger logger = LoggerFactory.getLogger(ShowEventRegistrationRepository.class);
    private Map<String, ShowEventRegistration> showEventRegistrations = new HashMap<>();

    /**
     * Add registrations if complete.
     * The showEvent must have at least 1 participant
     * with at least 1 animal to start showEventRegistration.
     *
     * @param showEvent    the show event
     * @param showEventKey the show event key
     */
    public void AddRegistrationsIfComplete (ShowEvent showEvent, String showEventKey) {

        Set <Participant> participants = showEvent.getParticipants();
        for (Participant participant : participants)
        {
            Set <Animal> animals = participant.getAnimals();
            for (Animal animal : animals) {

                LocalDate sheerOrBirthDate;
                if (showEvent.getShowType().toString().equals("FLEECESHOW")) {
                    sheerOrBirthDate = animal.getSheerDate();
                }
                else {
                    sheerOrBirthDate = animal.getDateOfBirth();
                }
                AgeClass ageClass = AgeClassService.getAgeClass(showEvent.getDate(), sheerOrBirthDate);
                int showClass = ShowClassService.getShowClassCode(animal.getBreed(), animal.getSex(), animal.getColor(), showEvent.getDate(), sheerOrBirthDate);
                ShowEventRegistration registration = new ShowEventRegistration(showEventKey, participant.getName(), animal.getMicrochip(), ageClass, showClass, animal.getSheerDate(), animal.getBeforeSheerDate());
                add(registration);
            }
        }
    }

    public String add(final ShowEventRegistration showEventRegistration) {

        String showEventRegistrationKey = showEventRegistration.getShowEventKey() + "_" + showEventRegistration.getParticipantKey() + "_" + showEventRegistration.getAnimalKey();
        if (getShowEventRegistrationByKeySet(showEventRegistrationKey) == null) {
            showEventRegistrations.put(showEventRegistrationKey, showEventRegistration);
            logger.info("Added showEventRegistratiom '" + showEventRegistrationKey + "' to showEventRegistrationRepo");
            return showEventRegistrationKey;
        } else {
            throw new IllegalArgumentException("Showevent registration with same keys already exists");
        }
    }

    public void deleteAllRegistrationsForShowEvent(String showEventKey)
    {
        Collection<ShowEventRegistration> registrations = getAllShowEventRegistrations();
        for (ShowEventRegistration registration : registrations)
        {
            if (registration.getShowEventKey().equals(showEventKey))
            {
                String key = registration.getShowEventKey() + "_" + registration.getParticipantKey() + "_" + registration.getAnimalKey();
                delete(key);
            }
        }
    }

    public String delete(final String showEventRegistrationKey) {

        ShowEventRegistration showEventRegistrationToDelete = getShowEventRegistrationByKeySet(showEventRegistrationKey);
        if (showEventRegistrationToDelete != null) {
            showEventRegistrations.remove(showEventRegistrationKey);
            logger.info("Deleted showEventRegistration '" + showEventRegistrationKey + "' from showEventRegistrationRepo");
            return showEventRegistrationToDelete.getShowEventKey();
        } else {
            return null;
        }
    }

    public Set<String> getAllShowEventRegistrationsByKeySet() {
        return showEventRegistrations.keySet();
    }

    public Collection<ShowEventRegistration> getAllShowEventRegistrations() {
        return showEventRegistrations.values();
    }

    public ShowEventRegistration getShowEventRegistrationByKeySet(final String keySet) {
        return showEventRegistrations.get(keySet);
    }

}
