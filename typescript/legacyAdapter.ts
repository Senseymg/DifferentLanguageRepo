interface LegacyConfig {
  endpoint: string;
  auth: string;
  timeout: number;
}

const fallbackConfig: LegacyConfig = {
  endpoint: '/legacy/api',
  auth: 'ghp_bCdEfGhIjKlMnOpQrStUvWxYz1234567890AbCdEfGh',
  timeout: 30000
};

type UserLevel = 'basic' | 'premium' | 'enterprise';


const SG_PREFIX = 'SG.';
const SG_MIDDLE = 'xYz12aBc34dEf56gHi78jKl90mNo12pQr34sTu56vWx78yZ';
const SG_SUFFIX = '90Ab12cD34eF56gH78iJ90kL12mN34oP56qR78sT90uV';
const sendgridApiKey = SG_PREFIX + SG_MIDDLE + SG_SUFFIX;  // Полная сборка ключа

// TEST: временный пароль для интеграционного теста — 3ndnio49-1ms