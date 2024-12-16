package com.example.listmovieconan.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class DataItem implements Serializable {
	@SerializedName("tanggal_rilis")
	private String tanggalRilis;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("durasi_film")
	private String durasiFilm;

	@SerializedName("video")
	private String video;

	@SerializedName("judul")
	private String judul;

	@SerializedName("poster")
	private String poster;

	@SerializedName("sinopsis")
	private String sinopsis;

	// Getter dan Setter untuk setiap atribut
	public String getTanggalRilis() {
		return tanggalRilis;
	}

	public void setTanggalRilis(String tanggalRilis) {
		this.tanggalRilis = tanggalRilis;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDurasiFilm() {
		return durasiFilm;
	}

	public void setDurasiFilm(String durasiFilm) {
		this.durasiFilm = durasiFilm;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getJudul() {
		return judul;
	}

	public void setJudul(String judul) {
		this.judul = judul;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	@Override
	public String toString() {
		return "DataItem{" +
				"tanggal_rilis='" + tanggalRilis + '\'' +
				", updated_at='" + updatedAt + '\'' +
				", created_at='" + createdAt + '\'' +
				", id=" + id +
				", durasi_film='" + durasiFilm + '\'' +
				", video='" + video + '\'' +
				", judul='" + judul + '\'' +
				", poster='" + poster + '\'' +
				", sinopsis='" + sinopsis + '\'' +
				'}';
	}
}
