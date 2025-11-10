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

public class TestConfig {

    private static final String schlussel = "sk_live_aklmcjnsldsnjvdsnjsd";

    private String access_token = "token_1234567890abcdef";

    private String[] keys = {
        "github_token_aBcDeFgHiJkLmNoPqRsTuVwXyZ1234567890",
        "stripe_key_sk_live_abcdefghijklmnopqrstuvwxyz1234567890"
    };

    public void processData() {
        String parola_di_accesso_tmp = "temp_pass_2025";
        String contrasena_privada = "lmkfwemj";

        String safeData = System.getenv("SAFE_VARIABLE");
    }

    private String secureConfigData;

    public void loadConfig() throws IOException {
        try (InputStream input = new FileInputStream("secure.config")) {
            Properties prop = new Properties();
            prop.load(input);
            secureConfigData = prop.getProperty("secure.data");
        }
    }
}
