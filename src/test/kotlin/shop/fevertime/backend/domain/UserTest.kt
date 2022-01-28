package shop.fevertime.backend.domain

import org.junit.jupiter.api.*
import org.junit.jupiter.api.function.Executable


internal class UserTest {

    @Nested
    @DisplayName("유저 객체 생성")
    inner class CreateUser {

        private var username: String? = null
        private var email: String? = null
        private var role: UserRole? = null
        private var kakaoId: String? = null
        private var imgUrl: String? = null

        @BeforeEach
        fun setup() {
            username = "user1"
            email = "user1@email.com"
            role = UserRole.USER
            kakaoId = "12456"
            imgUrl = "http://img.com/img"
        }

        @Test
        @DisplayName("정상 케이스")
        fun success() {
            val user = User("user1","user1@email.com",UserRole.USER,"12456", "http://img.com/img")

            Assertions.assertAll(
                Executable { Assertions.assertEquals(username, user.username) },
                Executable { Assertions.assertEquals(email, user.email) },
                Executable { Assertions.assertEquals(role, user.role) },
                Executable { Assertions.assertEquals(kakaoId, user.kakaoId) },
                Executable { Assertions.assertEquals(imgUrl, user.imgUrl) },
            )
        }

        @Nested
        @DisplayName("실패 케이스")
        inner class Fail {

            @Nested
            @DisplayName("유저 이름")
            inner class Username {

                @Test
                @DisplayName("null")
                fun fail_null() {
                    // given
                    username = null;
                    // when

                    // then
                }

                @Test
                @DisplayName("공백")
                fun fail_empty() {
                    // given
                    username = "";
                    // when

                    // then

                }

                @Test
                @DisplayName("이름 아홉글자")
                fun fail_length_nine() {
                    // given
                    username = "일이삼사오육칠팔구";
                    // when

                    // then

                }

            }
        }

    }

}