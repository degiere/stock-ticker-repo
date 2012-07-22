package net.degiere.ticker.repository;

import java.util.List;
import java.util.Set;

import net.degiere.ticker.Security;

public interface SecurityRepository {

	public abstract List<Security> findAll();

	public abstract List<Security> findBySector(String sector);

	public abstract List<Security> findByIndustry(String industry);

	public abstract List<Security> findByCountry(String country);

	public abstract Security findByTicker(String ticker);

	public abstract Set<String> findAllSectors();

	public abstract Set<String> findAllIndustries();

	public abstract Set<String> findAllCountries();

}