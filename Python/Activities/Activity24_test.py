import pytest

@pytest.fixture
def wallet_amount():
    amount=0
    return amount

@pytest.mark.parametrize("earned,spent,expected",[(30,10,20),(20,10,10)])
def test_parameterize(wallet_amount,earned,spent,expected):

    # Add earned to wallet
    wallet_amount += earned

    # Subtract spent from wallet
    wallet_amount -= spent

    # Assertion
    assert wallet_amount == expected





