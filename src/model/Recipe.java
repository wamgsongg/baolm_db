package model;

public class Recipe {
	private int recipeid;
	private int shopid;
	private String recipename;
	private double recipeprice;
	private int monthlysale;
	private String recipenotice;
	private String recipepath;
	private int reciperemain;
	private double recipediscount;
	private String recipestatus;
	public int getRecipeid() {
		return recipeid;
	}
	public void setRecipeid(int recipeid) {
		this.recipeid = recipeid;
	}
	public int getShopid() {
		return shopid;
	}
	public void setShopid(int shopid) {
		this.shopid = shopid;
	}
	public String getRecipename() {
		return recipename;
	}
	public void setRecipename(String recipename) {
		this.recipename = recipename;
	}
	public double getRecipeprice() {
		return recipeprice;
	}
	public void setRecipeprice(double recipeprice) {
		this.recipeprice = recipeprice;
	}
	public int getMonthlysale() {
		return monthlysale;
	}
	public void setMonthlysale(int monthlysale) {
		this.monthlysale = monthlysale;
	}
	public String getRecipenotice() {
		return recipenotice;
	}
	public void setRecipenotice(String recipenotice) {
		this.recipenotice = recipenotice;
	}
	public String getRecipepath() {
		return recipepath;
	}
	public void setRecipepath(String recipepath) {
		this.recipepath = recipepath;
	}
	public int getReciperemain() {
		return reciperemain;
	}
	public void setReciperemain(int reciperemain) {
		this.reciperemain = reciperemain;
	}
	public double getRecipediscount() {
		return recipediscount;
	}
	public void setRecipediscount(double recipediscount) {
		this.recipediscount = recipediscount;
	}
	public String getRecipestatus() {
		return recipestatus;
	}
	public void setRecipestatus(String recipestatus) {
		this.recipestatus = recipestatus;
	}
	
}
