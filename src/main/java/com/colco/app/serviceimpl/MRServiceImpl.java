package com.colco.app.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colco.app.entity.MedicalRepresentativeEntity;
import com.colco.app.exception.MRException;
import com.colco.app.exception.NoMRFoundException;
import com.colco.app.model.MedicalRepresentative;
import com.colco.app.model.Response;
import com.colco.app.repository.MRRepository;
import com.colco.app.service.MRService;

@Service
public class MRServiceImpl implements MRService {

	@Autowired
	private MRRepository mrRepository;

	@Override
	public boolean createMR(MedicalRepresentative medicalRepresentative) {

		boolean isSaved = false;

		try {
			MedicalRepresentativeEntity entity = new MedicalRepresentativeEntity();

			BeanUtils.copyProperties(medicalRepresentative, entity);
			MedicalRepresentativeEntity saveEntity = mrRepository.save(entity);
			if (saveEntity.getId() != null) {
				isSaved = true;
			}

		} catch (Exception e) {

			throw new MRException("Failed to Register MR");
		}
		return isSaved;

	}

	@Override
	public List<MedicalRepresentative> getAllMR() {

		List<MedicalRepresentative> list = new ArrayList<MedicalRepresentative>();
		List<MedicalRepresentativeEntity> entityList = mrRepository.findAll();

		entityList.forEach(entity -> {

			MedicalRepresentative mR = new MedicalRepresentative();
			BeanUtils.copyProperties(entity, mR);
			list.add(mR);

		});
		return list;

	}

	@Override
	public MedicalRepresentative getMRById(Integer id) {
		Optional<MedicalRepresentativeEntity> optional = mrRepository.findById(id);
		if (optional.isPresent()) {
			MedicalRepresentativeEntity entity = optional.get();
			MedicalRepresentative representative = new MedicalRepresentative();
			BeanUtils.copyProperties(entity, representative);

			return representative;
		}
		throw new NoMRFoundException("No MR Found with Given ID");
	}

	@Override
	public boolean deleteMRById(Integer id) {

		mrRepository.deleteById(id);
		return false;

	}

	@Override
	public boolean updateMR(Integer id, MedicalRepresentative medicalRepresentative) {

		Optional<MedicalRepresentativeEntity> optional = mrRepository.findById(id);

		if (optional.isPresent()) {
			MedicalRepresentativeEntity entity = optional.get();

			entity.setFirstName(medicalRepresentative.getFirstName());
			entity.setLastName(medicalRepresentative.getLastName());
			entity.setGender(medicalRepresentative.getGender());
			entity.setEmail(medicalRepresentative.getEmail());

			entity.setDrugs(medicalRepresentative.getDrugs());

			BeanUtils.copyProperties(medicalRepresentative, entity);
			MedicalRepresentativeEntity saveEntity = mrRepository.save(entity);

			if (saveEntity != null)
				return true;

		}

		return false;
	}

	@Override
	public List<Response> getJoinInformation() {

		List<Response> list = new ArrayList<Response>();
		List<Response> entityList = mrRepository.getJoinInformation();

		entityList.forEach(entity -> {

			Response mR = new Response();
			BeanUtils.copyProperties(entity, mR);
			list.add(mR);

		});
		return list;

	}

}
