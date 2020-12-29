package com.kf2y.tcool.service;

import java.util.List;

import com.kf2y.tcool.domain.Artisan;

public interface ArtisanService {

	public Artisan save(Artisan c);
	public void delete(Long id);
	public Artisan getById(Long id);
	public Artisan getByDomaine(String domaine);
	public List<Artisan> getAllArtisans();
}
