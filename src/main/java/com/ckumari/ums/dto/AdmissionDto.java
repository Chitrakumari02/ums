package com.gmaurya.ums.dto;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public class AdmissionDto {
	
    @NotBlank(message = "Student name cannot be blank")
    private String student_name;
    
    @NotBlank(message = "Father name cannot be blank")
    private String father_name;

    @NotBlank(message = "Mother name cannot be blank")
    private String mother_name;
    
    @NotBlank(message = "Course cannot be blank")
    private String course;
    
    @NotBlank(message = "Religion cannot be blank")
	private String religion;

    @NotBlank(message = "Gender cannot be blank")
    private String gender;

    @NotBlank(message = "House number cannot be blank")
    private String house_no;

    @NotBlank(message = "Street name cannot be blank")
    private String street_name;

    @NotBlank(message = "City cannot be blank")
    private String city;

    @NotBlank(message = "State cannot be blank")
    private String state;

    @NotBlank(message = "Country cannot be blank")
    private String country;

    @NotBlank(message = "Pincode cannot be blank")
    @Pattern(regexp = "^\\d{6}$", message = "Pincode must be exactly 6 digits")
    private String pin_code;
    
    @NotBlank(message = "Student phone number cannot be blank")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be exactly 10 digits")
    private String student_phone_no;
    
    @NotBlank(message = "Parent phone number cannot be blank")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be exactly 10 digits")
    private String parent_phone_no;
    
    @NotBlank(message = "Student email cannot be blank")
    @Email(message = "Student email should be valid")
    private String student_email;
    
    @NotBlank(message = "Parent email cannot be blank")
    @Email(message = "Parent email should be valid")
    private String parent_email;
    
    @NotBlank(message = "Category cannot be blank")
    private String category;
    
    @NotBlank(message = "High school board cannot be blank")
    private String high_school_board;
    
    @NotNull(message = "High school year of passing cannot be null")
    private int high_school_year_of_passing;
    
    @NotNull(message = "High school marks cannot be null")
    private float high_school_marks; 
    
    @NotBlank(message = "Intermediate board cannot be blank")
    private String intermediate_board;
    
    @NotNull(message = "Intermediate year of passing cannot be null")
    private int intermediate_year_of_passing;
    
    @NotNull(message = "Intermediate marks cannot be null")
    private float intermediate_marks;

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getFather_name() {
		return father_name;
	}

	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}

	public String getMother_name() {
		return mother_name;
	}

	public void setMother_name(String mother_name) {
		this.mother_name = mother_name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHouse_no() {
		return house_no;
	}

	public void setHouse_no(String house_no) {
		this.house_no = house_no;
	}

	public String getStreet_name() {
		return street_name;
	}

	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPin_code() {
		return pin_code;
	}

	public void setPin_code(String pin_code) {
		this.pin_code = pin_code;
	}

	public String getStudent_phone_no() {
		return student_phone_no;
	}

	public void setStudent_phone_no(String student_phone_no) {
		this.student_phone_no = student_phone_no;
	}

	public String getParent_phone_no() {
		return parent_phone_no;
	}

	public void setParent_phone_no(String parent_phone_no) {
		this.parent_phone_no = parent_phone_no;
	}

	public String getStudent_email() {
		return student_email;
	}

	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}

	public String getParent_email() {
		return parent_email;
	}

	public void setParent_email(String parent_email) {
		this.parent_email = parent_email;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getHigh_school_board() {
		return high_school_board;
	}

	public void setHigh_school_board(String high_school_board) {
		this.high_school_board = high_school_board;
	}

	public int getHigh_school_year_of_passing() {
		return high_school_year_of_passing;
	}

	public void setHigh_school_year_of_passing(int high_school_year_of_passing) {
		this.high_school_year_of_passing = high_school_year_of_passing;
	}

	public float getHigh_school_marks() {
		return high_school_marks;
	}

	public void setHigh_school_marks(float high_school_marks) {
		this.high_school_marks = high_school_marks;
	}

	public String getIntermediate_board() {
		return intermediate_board;
	}

	public void setIntermediate_board(String intermediate_board) {
		this.intermediate_board = intermediate_board;
	}

	public int getIntermediate_year_of_passing() {
		return intermediate_year_of_passing;
	}

	public void setIntermediate_year_of_passing(int intermediate_year_of_passing) {
		this.intermediate_year_of_passing = intermediate_year_of_passing;
	}

	public float getIntermediate_marks() {
		return intermediate_marks;
	}

	public void setIntermediate_marks(float intermediate_marks) {
		this.intermediate_marks = intermediate_marks;
	}

	public AdmissionDto(@NotBlank(message = "Student name cannot be blank") String student_name,
			@NotBlank(message = "Father name cannot be blank") String father_name,
			@NotBlank(message = "Mother name cannot be blank") String mother_name,
			@NotBlank(message = "Course cannot be blank") String course,
			@NotBlank(message = "Religion cannot be blank") String religion,
			@NotBlank(message = "Gender cannot be blank") String gender,
			@NotBlank(message = "House number cannot be blank") String house_no,
			@NotBlank(message = "Street name cannot be blank") String street_name,
			@NotBlank(message = "City cannot be blank") String city,
			@NotBlank(message = "State cannot be blank") String state,
			@NotBlank(message = "Country cannot be blank") String country,
			@NotBlank(message = "Pincode cannot be blank") @Pattern(regexp = "^\\d{6}$", message = "Pincode must be exactly 6 digits") String pin_code,
			@NotBlank(message = "Student phone number cannot be blank") @Pattern(regexp = "^\\d{10}$", message = "Phone number must be exactly 10 digits") String student_phone_no,
			@NotBlank(message = "Parent phone number cannot be blank") @Pattern(regexp = "^\\d{10}$", message = "Phone number must be exactly 10 digits") String parent_phone_no,
			@NotBlank(message = "Student email cannot be blank") @Email(message = "Student email should be valid") String student_email,
			@NotBlank(message = "Parent email cannot be blank") @Email(message = "Parent email should be valid") String parent_email,
			@NotBlank(message = "Category cannot be blank") String category,
			@NotBlank(message = "High school board cannot be blank") String high_school_board,
			@NotNull(message = "High school year of passing cannot be null") int high_school_year_of_passing,
			@NotNull(message = "High school marks cannot be null") float high_school_marks,
			@NotBlank(message = "Intermediate board cannot be blank") String intermediate_board,
			@NotNull(message = "Intermediate year of passing cannot be null") int intermediate_year_of_passing,
			@NotNull(message = "Intermediate marks cannot be null") float intermediate_marks) {
		super();
		this.student_name = student_name;
		this.father_name = father_name;
		this.mother_name = mother_name;
		this.course = course;
		this.religion = religion;
		this.gender = gender;
		this.house_no = house_no;
		this.street_name = street_name;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pin_code = pin_code;
		this.student_phone_no = student_phone_no;
		this.parent_phone_no = parent_phone_no;
		this.student_email = student_email;
		this.parent_email = parent_email;
		this.category = category;
		this.high_school_board = high_school_board;
		this.high_school_year_of_passing = high_school_year_of_passing;
		this.high_school_marks = high_school_marks;
		this.intermediate_board = intermediate_board;
		this.intermediate_year_of_passing = intermediate_year_of_passing;
		this.intermediate_marks = intermediate_marks;
	}

	public AdmissionDto() {
		// TODO Auto-generated constructor stub
	}

    
    
}
