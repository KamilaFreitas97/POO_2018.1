package twitter;

public class User {
	
	private String id;
	private Repositorio<User> seguidores;
	private Repositorio<User> seguidos;
	private Repositorio<Tweet> myTweets;
	private Repositorio<Tweet> timeline;
	int unreadCount = 0;//nao lida
	
	public User(String id) {
		this.id = id;		
		this.seguidores = new Repositorio<User>("seguidores");
		this.seguidos = new Repositorio<User>("seguidos");
		this.myTweets =  new Repositorio<Tweet>("myTweets");
		this.timeline = new Repositorio<Tweet>("timeline");
	}	
		


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



	public Repositorio<User> getSeguidores() {
		return seguidores;
	}


	public Repositorio<User> getSeguidos() {
		return seguidos;
	}


	/*public Repositorio<Tweet> getMyTweets() {
		return myTweets;
	}

	public void setMyTweets(Repositorio<Tweet> myTweets) {
		this.myTweets = myTweets;
	}*/

	public Repositorio<Tweet> getTimeline() {
		return timeline;
	}

	public int getUnreadCount() {
		return unreadCount;
	}

	public void setUnreadCount(int unreadCount) {
		this.unreadCount = unreadCount;
	}
	//metodos

	public void seguir(User u) {
		/*for(User u: seguidos.getAll())
			if(u.username == user.username)*/
	
		/*seguidos.add("", user);
		user.seguidores.add(username, this);*/
		//System.out.println("debug: " + getId() );
		u.seguidos.add(getId(), new User(getId()));
		seguidores.add(u.getId(), u);	
	}
	
	public void twittar(Tweet tweet) {
		myTweets.add("", tweet);
		for(User user : seguidores.getAll() ) {
			user.unreadCount += 1;
			user.timeline.add("", tweet);
		}
	}
	
	
	
	public String mostrarseguidores() {
		String mostrar = "";
		for(User seguidores : seguidores.getAll()) 
			mostrar += seguidores.id + " ";
		return mostrar;			
	}
	
	public String mostrarseguidos() {
		String mostrar = " ";
		for(User seg: seguidos.getAll())
			mostrar += seg.id + " ";
		return mostrar;	
	}
	
	public void CriarTweet(Tweet tweet) {
		this.myTweets.add(""+ tweet.getIdTweet(), tweet );
		//unreadCount++;
		}
	
	public void addTimeline(Tweet tweet) {
		this.timeline.add(""+ tweet.getIdTweet(), tweet);
	}
	
	
	public String MostrarmyTweet() {
		String mostrar = "";
		for(Tweet t : myTweets.getAll()) 
			mostrar += " "+ t.toString()+ "\n";
		//mostrar += " " + t.getIdTweet() + " " + t.getUser() + " " + t.getTitulo() + " " + t.getTexto();
		return mostrar;
		
	}
	
	
	
	public String MostrarTimeline() {
		String mostrar = "";
		String aux = "";
		
		for(Tweet t : timeline.getAll()) {
			if(!t.isMsglida()) {
				mostrar += t.toString() + "\n";
				t.setMsglida(true);
				unreadCount++;
			}
		}
		//conta tudo  pra depois mostrar
		aux += (" voce tem : " + unreadCount + " tweets \n");
		
		unreadCount = 0;
		return aux + mostrar;	
		
	}
	//dar like pelo idTweet
	public void darLike(int idTweet) {
		for(Tweet t: timeline.getAll()) {
			if(t.getIdTweet() == idTweet) {
				if(!t.isLike()) {
					t.setLike(true);
					return;
				}
			}
		}
		throw new RuntimeException("tweet nao esta disponivel para voce");
		
	}
	
	public String tostring() {
		return ""+ id;
	}
	
		
	
	}
	
