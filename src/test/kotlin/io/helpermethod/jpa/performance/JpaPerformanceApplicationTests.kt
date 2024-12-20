package io.helpermethod.jpa.performance

import io.helpermethod.jpa.performance.posts.Comment
import io.helpermethod.jpa.performance.posts.CommentRepository
import io.helpermethod.jpa.performance.posts.Post
import io.helpermethod.jpa.performance.posts.PostRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.quickperf.junit5.QuickPerfTest
import org.quickperf.sql.annotation.ExpectInsert
import org.quickperf.sql.annotation.ExpectSelect
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.data.repository.findByIdOrNull

@QuickPerfTest
@Import(TestcontainersConfiguration::class)
@SpringBootTest
class JpaPerformanceApplicationTests(
    @Autowired private val postRepository: PostRepository,
    @Autowired private val commentRepository: CommentRepository,
) {
    @ExpectSelect(1)
    @ExpectInsert(1)
    @Test
    fun `should persist posts`() {
        val post = postRepository.save(
            Post(
                title = "JPA Performance",
                content = "TBD"
            )
        )

        assertThat(postRepository.findByIdOrNull(post.id))
            .usingRecursiveComparison()
            .isEqualTo(post)
    }

    @ExpectSelect(1)
    @ExpectInsert(2)
    @Test
    fun `should persist comments`() {
        val post = postRepository.save(
            Post(
                title = "JPA Performance",
                content = "TBD"
            )
        )

        val comment = commentRepository.save(
            Comment(
                content = "This is a great blog post!",
                post = post
            )
        )

        assertThat(commentRepository.findCommentById(comment.id!!))
            .usingRecursiveComparison()
            .isEqualTo(comment)
    }
}
