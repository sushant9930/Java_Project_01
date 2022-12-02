package com.Pojo;

public class Movies {


		private String movie_id,movie_name, lang, release_date;
		private Float movie_rating, duration;
		
		
	
		public String getMovie_id() {
			return movie_id;
		}
		public void setMovie_id(String movie_id) {
			this.movie_id = movie_id;
		}
		public String getMovie_name() {
			return movie_name;
		}
		public void setMovie_name(String movie_name) {
			this.movie_name = movie_name;
		}
		public String getLang() {
			return lang;
		}
		public void setLang(String lang) {
			this.lang = lang;
		}
		public String getRelease_date() {
			return release_date;
		}
		public void setRelease_date(String release_date) {
			this.release_date = release_date;
		}
		public Float getMovie_rating() {
			return movie_rating;
		}
		public void setMovie_rating(Float movie_rating) {
			this.movie_rating = movie_rating;
		}
		public Float getDuration() {
			return duration;
		}
		public void setDuration(Float duration) {
			this.duration = duration;
		}
		
		
/*
		private String movie_id,movie_name, lang, release_date;
		private Float movie_rating, duration;
*/
	public String toString() 
	{
		return(getMovie_id()+"     "+getMovie_name()+"                   "+getLang()+"       "+getMovie_rating()+"            "+getDuration());
	}

}
