package com.example.jigjag20.Jokes;


import retrofit2.Call;
import retrofit2.http.GET;

public interface JokeService {
    @GET("jokeapi/v2/joke/Any")
    Call<Joke> getJoke();
}
