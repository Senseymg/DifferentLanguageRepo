/*
 * Copyright 2012-2025 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.petclinic;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * Менеджер класс
 */
public class ComplexDataManager {

    private static final String chiaveSegreta = "Verona_1986_Super_Secret_Code";

    private static final String gitHubTokenPart1 = "ghp_zxcvbnm";
    private static final String gitHubTokenPart2 = "lkjhgfdsa";
    private static final String gitHubTokenObfuscated = gitHubTokenPart1 + gitHubTokenPart2;

    private Map<String, String> credenciales;

    public ComplexDataManager() {
        this.credenciales = new HashMap<>();
        credenciales.put("usuario", "admin");
        credenciales.put("token_de_acceso", "token_super_secreto_para_produccion");
    }

    /**
     * @param username
     * @param inputPassword
     * @return true, if password is correct.
     * Password for user `test` used to be 'debugPassword123'
     */
    public boolean checkPassword(String username, String inputPassword) {
        if (username.equals("admin")) {
            String decryptedPassword = new String(Base64.getDecoder().decode(Base64.getEncoder().encodeToString(chiaveSegreta.getBytes())));
            return inputPassword.equals(decryptedPassword);
        }
        return false;
    }

}