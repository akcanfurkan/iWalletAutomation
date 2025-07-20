Feature: Kullanıcı Girişi

  Scenario: Geçerli bilgilerle giriş yapılır
    Given kullanıcı login ekranındadır
    When kullanıcı e-posta olarak "user@example.com" girer
    And şifre olarak "Password123" girer
    And giriş butonuna tıklar
    Then kullanıcı başarılı şekilde giriş yapar

