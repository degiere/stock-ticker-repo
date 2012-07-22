package net.degiere.ticker;

public class Security {

	public String ticker;
	public String company;
	public String sector;
	public String industry;
	public String country;
	public String marketCap;
	public String pe;
	public String price;
	public String change;
	public String volume;
	
	public Security() {}
	
	public Security(String ticker) {
		this.ticker = ticker;
	}
	
	@Override
    public String toString() {
	    return "Security [ticker=" + ticker +
	    		", company=" + company +
	    		", sector=" + sector +
	    		", industry=" + industry +
	    		", country=" + country +
	    		", marketCap=" + marketCap +
	            ", pe=" + pe +
	            ", price=" + price +
	            ", change=" + change +
	            ", volume=" + volume + "]";
    }

	@Override
    public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((ticker == null) ? 0 : ticker.hashCode());
	    return result;
    }

	@Override
    public boolean equals(Object obj) {
	    if (this == obj)
		    return true;
	    if (obj == null)
		    return false;
	    if (getClass() != obj.getClass())
		    return false;
	    Security other = (Security) obj;
	    if (ticker == null) {
		    if (other.ticker != null)
			    return false;
	    } else if (!ticker.equals(other.ticker))
		    return false;
	    return true;
    }

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMarketCap() {
		return marketCap;
	}

	public void setMarketCap(String marketCap) {
		this.marketCap = marketCap;
	}

	public String getPe() {
		return pe;
	}

	public void setPe(String pe) {
		this.pe = pe;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getChange() {
		return change;
	}

	public void setChange(String change) {
		this.change = change;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

}
