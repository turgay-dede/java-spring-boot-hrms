package kodlamaio.hrms.business.constants;

public class Messages {
	//User
	public static String listedByEmail = "Email adresine göre kullanıcı listelendi"; 
	public static String notFoundByEmail = "Email adresine göre kullanıcı bulunamadı"; 
	
	//Candidate
	public static String candidateAdded = "İş arayan eklendi"; 
	public static String candidateListed = "İş arayanlar listelendi";	
	public static String listedByIdentificationNumber = "TC kimlik numarasına göre listelendi";
	public static String notFoundByIdentificationNumber = "TC numarasına göre bulunamadı";
	
	//Employer
	public static String invalidPhoneNumber = "Geçersiz telefon numarası girdiniz"; 
	public static String emloyerAdded = "İş veren eklendi";
	
	//JobTitle
	public static String jobTitleAdded = "İş pozisyonu eklendi";
	public static String jobTitleExists = "Bu pozisyon daha önce eklenmiş";
	public static String foundJobTitle = "İş pozisyonu bulundu";
	public static String notFoundJobTitle = "İş pozisyonu bulunamadı";
	
	//Auth
	public static String allFieldsFilled = "Tüm alanlar doldurulmalıdır"; 
	public static String mailFormatNotValid = "Geçersiz email formatı girildi";
	public static String emailExists = "Bu email zaten mevcut"; 
	public static String IdentificationNumberExists = "Bu TC kimlik numarası zaten mevcut";
	public static String passwordNotMatched = "Şifre eşleşmedi";
	public static String verificationError = "Doğrulama hatası";
	public static String registerAndVerification = "Kayıt olundu. Email doğrulaması yapınız.";
	public static String emailEqualsToDomain = "Domain adi ve eposta ayni olmalidir";
	public static String verifiedEmployer = "İş veren onaylandı";
	public static String verifiedCandidate = "İş arayan onaylandı"; 
	
	//VerificationCode
	public static String codeGenerated = "Kod oluşturuldu";
	public static String verificationCodeAdded="Doğrulama kodu eklendi";
	
	//JobPosting
	public static String addJobPosting = "İlan eklendi"; 
	public static String passiveJobPosting = "İlan kapatıldı"; 
	public static String activeJobPostingListed = "Aktif ilanlar listelendi";
	public static String notFoundActiveJobPosting = "Aktif ilan bulunamadı";
	public static String companyActivePostingListed = "Şirketin aktif ilanları listelendi";
	
}
