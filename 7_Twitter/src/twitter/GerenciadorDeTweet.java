package twitter;

public class GerenciadorDeTweet {
	private Repositorio<Tweet> tweets;
	
	public GerenciadorDeTweet() {
		tweets = new Repositorio<Tweet>("tweets");		
	}

	public Repositorio<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(Repositorio<Tweet> tweets) {
		this.tweets = tweets;
	}
	
	public void GeradorDeTweet(Tweet tweet) {
		this.tweets.add(""+tweet.getIdTweet(), tweet);
	}
	
	public String mostrarTweets() {
		String saida = "";
		for(Tweet t : tweets.getAll()) {
			saida += t.toString()+ "\n";
		}
		return saida;
		
	}
	
	

}
