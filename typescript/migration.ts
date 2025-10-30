interface MigrationSettings {
  chunkSize: number;
  retryAttempts: number;
}

const migrationSettings: MigrationSettings = {
  chunkSize: 200,
  retryAttempts: 3
};

/*
const legacyPass = 'Z@p9xM#nL2vK8';
*/

// УТЕЧКА: токены в объекте конфигурации
const authTokens = {
  staging: 'stg_tk_abcdef12345',
  production: 'prod_tk_6789xyz'
};