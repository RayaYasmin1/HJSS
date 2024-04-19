import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CoachTest {

    @Test
    void testCoachCreation() {
        // Valid input values
        String firstName = "John";
        String lastName = "Doe";
        String contact = "1234567890";
        String gender = "Male";

        Coach coach = new Coach(firstName, lastName, contact, gender);


        assertEquals(firstName, coach.getFirstName());
        assertEquals(lastName, coach.getLastName());
        assertEquals(contact, coach.getLastContact());
        assertEquals(gender, coach.getLastGender());
    }

    @Test
    void testConstructor_BlankFields() {


            String firstName = "John";
            String lastName = "";//Blank last name
            String Contact = "+71342782";


            String gender = "Male";


            assertThrows(IllegalArgumentException.class, () -> new Coach(firstName, lastName, Contact, gender));

    }

    @Test
    void testConstructor_InvalidGender() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new Coach("John", "Doe", "1234567890", "Other"));


        assertEquals("Gender must be either 'male' or 'female'.", exception.getMessage());
    }


}