import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class LearnerTest {

    @Test
    void testLearnerCreation() {
        // Test data
        String firstName = "John";
        String lastName = "Doe";
        String grade = "5";
        int age = 10;
        String emergencyContact = "1234567890";
        String gender = "Male";

        // Create a Learner object
        Learner learner = new Learner(firstName, lastName, grade, age, emergencyContact, gender);

        // Verify the properties of the Learner object
        assertEquals(firstName, learner.getFirstName());
        assertEquals(lastName, learner.getLastName());
        assertEquals(grade, learner.getGrade());
        assertEquals(age, learner.getAge());
        assertEquals(emergencyContact, learner.getEmergencyContact());
        assertEquals(gender, learner.getGender());
    }
    @Test
    void testLearnerConstructor_Blank_fields() {

        String firstName = "John";
        String lastName = "";//Blank last name
        String grade = "Grade 5";
        int age = 5;
        String emergencyContact = "1234567890";
        String gender = "Male";

        // Verify that an IllegalArgumentException is thrown when creating the Learner object
        assertThrows(IllegalArgumentException.class, () -> new Learner(firstName, lastName, grade, age, emergencyContact, gender));
    }
   @Test
    void testLearnerConstructor_InvalidAge() {
        // Test data with an invalid age
        String firstName = "John";
        String lastName = "Doe";
        String grade = "Grade 5";
        int age = 15; // Invalid age
        String emergencyContact = "1234567890";
        String gender = "Male";

        // Verify that an IllegalArgumentException is thrown when creating the Learner object
        assertThrows(IllegalArgumentException.class, () -> new Learner(firstName, lastName, grade, age, emergencyContact, gender));
    }

    @Test
    void testLearnerConstructor_InvalidGender() {
        // Test data with an invalid age
        String firstName = "John";
        String lastName = "Doe";
        String grade = "Grade 5";
        int age = 5;
        String emergencyContact = "1234567890";
        String gender = "Ma";// Invalid gender..

        // Verify that an IllegalArgumentException is thrown when creating the Learner object
        assertThrows(IllegalArgumentException.class, () -> new Learner(firstName, lastName, grade, age, emergencyContact, gender));
    }



    @Test
    void testLearnerConstructor_InvalidGrade() {
        // Test data with an invalid age
        String firstName = "John";
        String lastName = "Doe";
        String grade = "6";// Invalid grade..
        int age = 5;
        String emergencyContact = "1234567890";
        String gender = "Male";

        // Verify that an IllegalArgumentException is thrown when creating the Learner object
        assertThrows(IllegalArgumentException.class, () -> new Learner(firstName, lastName, grade, age, emergencyContact, gender));
    }




}
