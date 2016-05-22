package com.phonebook;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration
@WebIntegrationTest
@Transactional
public class JpaNoteRepositoryIntegrationTests {

   /* @Autowired
    JpaNoteRepository repository;

    @Test
    public void findsAllNotes() {

        List<Person> notes = this.repository.findAll();
        Assert.assertThat(notes).hasSize(4);
        for (Person note : notes) {
            assertThat(note.getPhones().size()).isGreaterThan(0);
        }
    }*/

}