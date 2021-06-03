package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.Resume;

public interface ResumeService {
	DataResult<Resume> add(Resume resume);
	
	Result delete(int resumeId);
	
	Result update(Resume resume);

	DataResult<List<Resume>> getAll();

	DataResult<List<Resume>> getById(int candidateId);
	
	DataResult<List<Resume>> getAllResumeSortedByCreatedAt();
	
	Result savePhoto(MultipartFile file, int resumeId);

}
