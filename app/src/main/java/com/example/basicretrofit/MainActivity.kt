package com.example.basicretrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.basicretrofit.ui.theme.BasicRetrofitTheme

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository = Repository()
        val viewModelFactory = PostsViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[PostViewModel::class.java]
        setContent {


            PostListScreen(
                viewModel = viewModel,
                modifier = Modifier.padding(4.dp)
            )
        }


    }

    @Composable
    fun PostListScreen(viewModel: PostViewModel, modifier: Modifier = Modifier) {
        val posts by viewModel.posts.collectAsState()


            PostList(posts, modifier)

    }

    @Composable
    fun PostCard(post: Post, modifier: Modifier) {
        ElevatedCard(
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = post.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = post.body,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }
    }

    @Composable
    fun PostList(posts: List<Post>, modifier: Modifier) {
        LazyColumn(modifier = modifier.padding(16.dp)) {
            items(posts) { post ->

                PostCard(post = post, modifier = Modifier.padding(bottom = 8.dp))
            }
        }
    }


}



